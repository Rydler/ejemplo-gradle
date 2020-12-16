/*forma de invocación de método call:
def ejecucion = load 'maven.groovy'
ejecucion.call()
*/

def call(){
    stages {
        stage('Compile') {
            steps {
                sh './mvnw clean compile -e'
            }
        }

        stage('Test') {
            steps {
                sh './mvnw clean test -e'
            }
        }

        stage('Jar') {
            steps {
                sh './mvnw clean package -e'
            }
        }

        stage('Sonar') {
            steps {
                withSonarQubeEnv('Sonar') { // You can override the credential to be used
                    sh './mvnw org.sonarsource.scanner.maven:sonar-maven-plugin:3.7.0.1746:sonar'
                }
            }
        }

        stage('UploadNexus') {
            steps {
                nexusPublisher nexusInstanceId: 'Nexus_server_local', nexusRepositoryId: 'test-repo', packages: [[$class: 'MavenPackage', mavenAssetList: [[classifier: '', extension: 'jar', filePath: '/var/lib/jenkins/workspace/example_choice/build/libs/DevOpsUsach2020-0.0.1.jar']], mavenCoordinate: [artifactId: 'DevOpsUsach2020', groupId: 'com.devopsusach2020', packaging: 'jar', version: '1.0.2.maven']]]
            }
        }       

}

return this;