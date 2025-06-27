pipeline {
  agent any

  parameters {
    string(name: 'branch_name', defaultValue: 'main', description: 'Git branch to build')
  }

  tools {
    jdk 'jdk23'        // Ensure you've configured JDK 23 in Manage Jenkins ▸ Global Tool Configuration
    maven 'mvn_home'   // Likewise, ensure Maven is named mvn_home
  }

  stages {
    stage('pixel_mmp_healthcheck') {
      steps {
        script {
          try {
            git branch: params.branch_name, url: 'https://github.com/sudheermca51/gitbash_repo.git'
            sh '''
              chmod +x mmppixel_hlth-check.sh
              ./mmppixel_hlth-check.sh
            '''
          } catch (err) {
            echo "pixel_mmp_healthcheck job failed: ${err}"
          }
        }
      }
    }

    stage('pixel_mmp_regtests') {
      steps {
        script {
          git branch: params.branch_name, url: 'https://github.com/sudheermca51/pixelmmp.git'
          dir('mmppixel') {
            def javaHome = tool name: 'jdk23', type: 'jdk'
            def mvnHome = tool name: 'mvn_home', type: 'maven'
            withEnv([
              "JAVA_HOME=${javaHome}",
              "PATH+JAVA=${javaHome}/bin",
              "PATH+MAVEN=${mvnHome}/bin"
            ]) {
              sh 'java -version'
              sh 'mvn clean test'
            }
          }
        }
      }
    }
  }

  post {
    always {
      echo "Build completed with status: ${currentBuild.currentResult}"
    }
  }
}
