//forma de invocación de método call:
def ejecucion = load 'maven.groovy'
ejecucion.call()

def call(){
    stage('Build & Test'){
        echo 'Hola Mundo'
    }        

}

return this;