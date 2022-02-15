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
                archiveArtifacts artifacts: '**', fingerprint: true
            }
        }  
        
        stage('Deploy'){
 
            steps{
                nexusPublisher nexusInstanceId: 'localnexus3', nexusRepositoryId: 'nexus_spring', packages: [[$class: 'MavenPackage', mavenAssetList: [[classifier: '', extension: '', filePath: 'C:\\Projects\\Java\\training\\target\\training-0.1.1-SNAPSHOT.jar']], mavenCoordinate: [artifactId: 'training', groupId: 'clinic.programming', packaging: 'jar', version: '0.1.1-SNAPSHOT']]]
            }

 
        }
   
             
    }
	
}