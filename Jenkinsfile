pipeline {
    agent any

    stages {
        stage('pixel_mmp_healthcheck') {
            steps {
                git branch: 'main', url: 'https://github.com/sudheermca51/gitbash_repo.git'
                dir('gitbash_repo') {
                           sh 'mmphealthcheck.bat'
                }
            }
        }
        stage('pixel_mmp_regtests') {
            steps {
               git branch: 'main', url: 'https://github.com/sudheermca51/pixelmmp.git'
               dir('mmppixel') 
               {
                           sh 'mvn clean test'
               }
            }
        }
    }
}
