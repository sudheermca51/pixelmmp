pipeline {
  agent any

  parameters {
    string(name: 'branch_name', defaultValue: 'main', description: 'Git branch to build')
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
            def mvnHome = tool name: 'mvn_home', type: 'maven'
            withEnv([
              "PATH+MAVEN=${mvnHome}/bin",
              // If your mac agent needs it, e.g. /usr/local/bin for brew-installed tools
              "PATH+BREW=/usr/local/bin:/opt/homebrew/bin"
            ]) {
              sh 'mvn clean test'
            }
          }
        }
      }
    }
  }
}
