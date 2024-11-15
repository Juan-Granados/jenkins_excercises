pipeline {
    agent none
    parameters {
        string(name: 'NAME1', defaultValue: 'Juan', description: 'Name for the first agent')
        string(name: 'NAME2', defaultValue: 'Maria', description: 'Name for the second agent')
        string(name: 'NAME3', defaultValue: 'Carlos', description: 'Name for the third agent')
        string(name: 'NAME4', defaultValue: 'Ana', description: 'Name for the fourth agent')
    }
    environment {
        REPO_URL = 'https://github.com/Juan-Granados/jenkins_excercises'
        JAR_PATH = 'target/jenkins_excercises-alpha.jar'
        MAIN_CLASS = 'com.name_counter.App'
    }
    stages {
        stage('Parallel Execution') {
            parallel {
                stage('Parallel Execution 1') {
                    agent any  // Can be any agent for parallel execution
                    steps {
                        script {
                            executeBuild(params.NAME1, "Execution 1")
                        }
                    }
                }
                stage('Parallel Execution 2') {
                    agent any
                    steps {
                        script {
                            executeBuild(params.NAME2, "Execution 2")
                        }
                    }
                }
                stage('Parallel Execution 3') {
                    agent any
                    steps {
                        script {
                            executeBuild(params.NAME3, "Execution 3")
                        }
                    }
                }
                stage('Parallel Execution 4') {
                    agent any
                    steps {
                        script {
                            executeBuild(params.NAME4, "Execution 4")
                        }
                    }
                }
            }
        }
    }
}

def executeBuild(String name, String executionName) {
    try {
        // Display status to Jenkins UI
        echo "Starting build for ${name} (${executionName})"

        // wait for clone to end
        sleep(3)

        // Build with Maven
        echo "Building with Maven for ${name} (${executionName})"
        bat 'mvn clean install'  // Adjusted for Windows

        // Run the Java application
        echo "Running Java with ${name} (${executionName})"
        bat "java -cp ${env.JAR_PATH} ${env.MAIN_CLASS} ${name}"  // Adjusted for Windows

        // Indicate success
        echo "Build completed successfully for ${name} (${executionName})"
    } catch (Exception e) {
        // In case of failure, display an error message
        echo "Build failed for ${name} (${executionName})"
        currentBuild.result = 'FAILURE'
        throw e
    } finally {
        // Clean up after execution, even if previous steps fail
        echo "Cleaning up after execution for ${name} (${executionName})"
        try {
            timeout(time: 1, unit: 'SECONDS') {
                retry(10) {
                    cleanWs()  // Try cleaning workspace, but don't fail the pipeline if it fails
                }
            }
        } catch (Exception cleanupEx) {
            echo "Cleanup failed for ${name} (${executionName}) but continuing with the pipeline"
        }
    }
}
