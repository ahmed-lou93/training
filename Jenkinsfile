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
        //stage('Sonar') {
        //    steps {
          //      withSonarQubeEnv('SonarQube') { 
              //   bat ' mvn sonar:sonar'
            //    }
                
        //    }
        //}*/
        stage('Package') {
            steps {
                echo 'Packaging'
                bat 'mvn package -DskipTests'
                archiveArtifacts artifacts: '**', fingerprint: true
            }
        }  
        
        stage('Deploy'){
 
            steps{
                nexusArtifactUploader artifacts: [[artifactId: 'training', classifier: '', file: 'C:\\Projects\\Java\\training\\target\\training-0.1.1-SNAPSHOT.jar', type: 'jar']], credentialsId: 'nexus_credentials', groupId: 'clinic.programming', nexusUrl: 'http://localhost:9001/repository/nexus_spring/', nexusVersion: 'nexus3', protocol: 'http', repository: 'nexus_spring', version: '0.1.1-SNAPSHOT'
            }

 
        }
   
             
    }
	
}