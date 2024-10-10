pipeline {
    agent any

    environment {
        REGION = 'ap-northeast-2'
        ACC_BACK_IMAGE_NAME = '339713037008.dkr.ecr.ap-northeast-2.amazonaws.com/acc_back'
        ECR_PATH = '339713037008.dkr.ecr.ap-northeast-2.amazonaws.com'
        AWS_CREDENTIAL_NAME = 'aws-key'
    }

    stages {
        stage('Pull Codes from Github') {
            steps {
                checkout scm
            }
        }

        stage('Check PATH') {
            steps {
                script {
                    bat 'echo %PATH%'  // Windows에서 PATH 확인
                }
            }
        }

        // 회계 프론트엔드 및 백엔드 서비스 배포
        stage('Apply Services') {
            steps {
                script {
                    withCredentials([[$class: 'AmazonWebServicesCredentialsBinding', credentialsId: 'aws-key']]) {
                        bat 'kubectl apply -f E:/docker_Logi/acc-front-service.yaml'
                        bat 'kubectl apply -f E:/docker_Logi/acc-back-service.yaml'
                    }
                }
            }
        }

        stage('Update Backend Properties with Frontend URL') {
            steps {
                script {
                    withCredentials([[$class: 'AmazonWebServicesCredentialsBinding', credentialsId: 'aws-key']]) {

                        // 1. kubectl 명령어로 회계 프론트엔드 서비스의 호스트 이름을 가져옴
                        def acc_front_service_url = powershell(script: 'kubectl get service acc-front-service -o jsonpath="{.status.loadBalancer.ingress[0].hostname}"', returnStdout: true).trim()

                        // 2. 출력 확인
                        echo "Accounting Frontend Service URL: ${acc_front_service_url}"

                        // 3. PowerShell 스크립트로 application.yml 파일 업데이트
                        bat """
                        powershell -Command "\$accFrontendUrl = '${acc_front_service_url}'; (Get-Content 'E:\\docker_Logi\\acc_react_back_cloud\\src\\main\\resources\\application.yml') -replace 'FRONTEND_SERVICE_URL:.*', 'FRONTEND_SERVICE_URL: http://\$accFrontendUrl' | Set-Content 'E:\\docker_Logi\\acc_react_back_cloud\\src\\main\\resources\\application.yml';"
                        """
                    }
                }
            }
        }

        stage('Build Codes by Gradle') {
            steps {
                script {
                    bat "./gradlew clean build"
                }
            }
        }

        stage('Dockerizing Project by Dockerfile') {
            steps {
                script {
                    bat "docker build -t ${ACC_BACK_IMAGE_NAME}:latest ."
                    bat "docker tag ${ACC_BACK_IMAGE_NAME}:latest ${ACC_BACK_IMAGE_NAME}:latest"
                }
            }
        }

        stage('Upload to AWS ECR') {
            steps {
                script {
                    docker.withRegistry("https://$ECR_PATH", "ecr:$REGION:$AWS_CREDENTIAL_NAME") {
                        docker.image("$ACC_BACK_IMAGE_NAME:latest").push()
                    }
                }
            }
        }

        // 회계 백엔드 디플로이먼트 적용
        stage('Apply Backend Deployment') {
            steps {
                script {
                    withCredentials([[$class: 'AmazonWebServicesCredentialsBinding', credentialsId: 'aws-key']]) {
                        bat 'kubectl apply -f E:/docker_Logi/acc-back-deployment.yaml'
                    }
                }
            }
        }
    }
}
