pipeline {
    agent any

    stages {
        stage('Pipeline') {
            steps{
                script{
                    stage('Build & Test'){
                        sh './gradlew clean build'
                    }
                    stage('Sonar'){
                        def scannerHome = tool 'sonar';
                        withSonarQubeEnv('sonar') { // If you have configured more than one global server connection, you can specify its name
                            sh "${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=ejemplo-gradle -Dsonar.java.binaries=build"
                        }
                    }
                    stage('Run'){

                    }
                    stage('Test'){

                    }
                    stage('Nexus'){

                    }
                }
            }
        }
    }
}


