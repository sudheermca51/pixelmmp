pipeline {
    agent any

    stages {
        stage('pixel_mmp_healthcheck') {
            steps {
                git branch: 'main', url: 'https://github.com/sudheermca51/gitbash_repo.git'
                bat label: 'mmpbatchscript', script: 'mmphealthcheck.bat'
            }
        }
        stage('pixel_mmp_regtests') {
            steps {
               git branch: 'main', url: 'https://github.com/sudheermca51/pixelmmp.git'
               dir('mmppixel') 
               {
                           bat 'mvn clean test'
               }
            }
        }
    }
}
