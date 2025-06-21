pipeline {
    agent any

    stages {
        stage('pixel_mmp_healthcheck') {
                steps {
                    
            script{
                try{
                    git branch: "${env.BRANCH_NAME}", url: 'https://github.com/sudheermca51/gitbash_repo.git'
                    bat label: 'mmpbatchscript', script: 'mmphealthcheck.bat'
                  }
             
            catchError(err) {
                  echo "pixel_mmp_healthcheck job failed"
                  echo "Caught: ${err}"
             }
            }
                }
        }
        stage('pixel_mmp_regtests') {
            steps {
               git branch: "${env.BRANCH_NAME}", url: 'https://github.com/sudheermca51/pixelmmp.git'
               dir('mmppixel') 
               {
                           bat 'mvn clean test'
               }
            }
        }
    }
}
