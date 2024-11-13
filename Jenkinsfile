pipeline {
    agent none  // No global agent is assigned (since we'll use multiple agents in parallel)
    parameters {
        string(name: 'NAME1', defaultValue: 'Juan', description: 'Name for the first agent')
        string(name: 'NAME2', defaultValue: 'Maria', description: 'Name for the second agent')
        string(name: 'NAME3', defaultValue: 'Carlos', description: 'Name for the third agent')
        string(name: 'NAME4', defaultValue: 'Ana', description: 'Name for the fourth agent')
        string(name: 'NAME5', defaultValue: 'Pedro', description: 'Name for the fifth agent')

    }
    stages {
        stage('Parallel Execution') {
            parallel {
                stage('Agent 1') {
                    agent { label 'Agent1' }
                    steps {
                        script {
                            echo 'Cloning repository'
                            checkout scm
                            echo 'Building with Maven'
                            sh 'mvn clean install'
                            sh 'java -cp target/jenkins_excercises-alpha.jar com.name_counter.App ${params.NAME1}'
                        }
                    }
                }
                stage('Agent 2') {
                    agent { label 'Agent2' }
                    steps {
                        script {
                            echo 'Cloning repository'
                            checkout scm
                            echo 'Building with Maven'
                            sh 'mvn clean install'
                            sh 'java -cp target/jenkins_excercises-alpha.jar com.name_counter.App ${params.NAME2}'
                        }
                    }
                }
                stage('Agent 3') {
                    agent { label 'Agent3' }
                    steps {
                        script {
                            echo 'Cloning repository'
                            checkout scm
                            echo 'Building with Maven'
                            sh 'mvn clean install'
                            sh 'java -cp target/jenkins_excercises-alpha.jar com.name_counter.App ${params.NAME3}'
                        }
                    }
                }
                stage('Agent 4') {
                    agent { label 'Agent4' }
                    steps {
                        script {
                            echo 'Cloning repository'
                            checkout scm
                            echo 'Building with Maven'
                            sh 'mvn clean install'
                            sh 'java -cp target/jenkins_excercises-alpha.jar com.name_counter.App ${params.NAME4}'
                        }
                    }
                }
                stage('Agent 5') {
                    agent { label 'Agent5' }
                    steps {
                        script {
                            echo 'Cloning repository'
                            checkout scm
                            echo 'Building with Maven'
                            sh 'mvn clean install'
                            sh 'java -cp target/jenkins_excercises-alpha.jar com.name_counter.App ${params.NAME5}'
                        }
                    }
                }
            }
        }
    }
}
