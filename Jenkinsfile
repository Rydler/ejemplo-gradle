pipeline {
    agent any
    parameters { choice(name: 'CHOICES', choices: ['gradle', 'maven'], description: 'Invocacion ') }

    stages {
        stage('Pipeline') {
            steps{
                script{
                    println 'Herramienta de ejecución:' + params.CHOICES
                    def eleccion = load "${params.CHOICES}.groovy"
                    eleccion.call() 
                }
            }
        }
    }
}

/*
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
                        sh 'nohup bash gradlew  bootRun &'
                        sleep 10
                    }
                    stage('Test'){
                        sh 'curl -X GET http://localhost:8082/rest/mscovid/test?msg=testing'
                    }
                    stage('Nexus'){
                        nexusPublisher nexusInstanceId: 'Nexus_server_local', nexusRepositoryId: 'test-repo', packages: [[$class: 'MavenPackage', mavenAssetList: [[classifier: '', extension: 'jar', filePath: '/var/lib/jenkins/workspace/ranch_gradle_feature-dir-inicial/build/libs/DevOpsUsach2020-0.0.1.jar']], mavenCoordinate: [artifactId: 'DevOpsUsach2020', groupId: 'com.devopsusach2020', packaging: 'jar', version: '1.0.1']]]
                    }
*/
