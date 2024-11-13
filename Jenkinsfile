pipeline {
    agent none  // No global agent is assigned (since we'll use multiple agents in parallel)
    parameters {
        string(name: 'NAME1', defaultValue: 'Juan', description: 'Name for the first agent')
        string(name: 'NAME2', defaultValue: 'Maria', description: 'Name for the second agent')
        string(name: 'NAME3', defaultValue: 'Carlos', description: 'Name for the third agent')
        string(name: 'NAME4', defaultValue: 'Ana', description: 'Name for the fourth agent')
        string(name: 'NAME5', defaultValue: 'Pedro', description: 'Name for the fifth agent')
    }
    environment {
        REPO_URL = 'https://github.com/Juan-Granados/jenkins_excercises'
        JAR_PATH = 'target/jenkins_excercises-alpha.jar'
        MAIN_CLASS = 'com.name_counter.App'
    }
    stages {
        stage('Parallel Execution') {
            parallel {
                'Agent 1': {
                    agent { label 'Agent1' }
                    steps {
                        script {
                            executeBuild(params.NAME1)
                        }
                    }
                },
                'Agent 2': {
                    agent { label 'Agent2' }
                    steps {
                        script {
                            executeBuild(params.NAME2)
                        }
                    }
                },
                'Agent 3': {
                    agent { label 'Agent3' }
                    steps {
                        script {
                            executeBuild(params.NAME3)
                        }
                    }
                },
                'Agent 4': {
                    agent { label 'Agent4' }
                    steps {
                        script {
                            executeBuild(params.NAME4)
                        }
                    }
                },
                'Agent 5': {
                    agent { label 'Agent5' }
                    steps {
                        script {
                            executeBuild(params.NAME5)
                        }
                    }
                }
            }
        }
    }
}

def executeBuild(String name) {
    echo "Cloning repository for ${name}"
    checkout scm
    echo 'Building with Maven'
    sh 'mvn clean install'
    echo "Running Java with ${name}"
    sh "java -cp ${env.JAR_PATH} ${env.MAIN_CLASS} ${name}"
}
