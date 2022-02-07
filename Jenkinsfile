pipeline{
	agent any

    stages {
        stage('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
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
    }
	
}