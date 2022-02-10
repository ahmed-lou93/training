pipeline{
	agent any

    stages {
        stage('Initialize') {
            steps {
                bat '''
                    echo "PATH = %PATH%"
                    echo "M2_HOME = %M2_HOME%"
                '''
            }
        }
        stage('Cloning Git') {
            steps {
                git(
                     url: 'https://github.com/ahmed-lou93/training.git',
                     credentialsId: 'jenkins-private-pat'
                )
            }
        }
        stage("build") {
            steps {
                echo 'Clean Build'
                bat 'mvn clean compile'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing'
                bat 'mvn test'
            }
        }
        
        stage('JaCoCo') {
            steps {
                echo 'Code Coverage'
                jacoco()
            }
        }
        stage('Sonar') {
            steps {
                withSonarQubeEnv('SonarQube') { 
                 bat ' mvn sonar:sonar'
                }
                
            }
        }
        stage('Package') {
            steps {
                echo 'Packaging'
                bat 'mvn package -DskipTests'
                archiveArtifacts artifacts: 'training.jar', fingerprint: true

            }
        }
              
    }
	
}