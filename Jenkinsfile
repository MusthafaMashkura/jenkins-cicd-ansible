pipeline {
    agent any
    tools { 
        maven 'mymaven' 
        jdk 'myjdk' 
    }
     
    stages {
      stage('checkout') {
           steps {
             
                git branch: 'jenkins-selenium-grid', url: 'https://github.com/MusthafaMashkura/jenkins-cicd-ansible.git'
             
          }
        }
  /*    stage('Code Analysis') {
           steps {
                withSonarQubeEnv('mysonarqube')
               {
                   sh 'mvn sonar:sonar'
               }
           }
         }
       stage("Quality Gate result") {
            steps {
                timeout(time: 1, unit: 'HOURS') {
                    // Parameter indicates whether to set pipeline to UNSTABLE if Quality Gate fails
                    // true = set pipeline to UNSTABLE, false = don't
                    waitForQualityGate abortPipeline: true
                }
            }
        }*/
  /*                   stage('Owasp Dependency check') {
           steps {
               dependencyCheck additionalArguments: '--format HTML', odcInstallation: 'my-dpcheck'
            }
        }*/
      stage('Build') {
           steps {
               sh 'mvn clean package -DskipTests'
            }
        }
      stage('Check Ansible version') {
           steps {
               sh 'ansible --version'
               sh 'python --version'
            }
        }
      stage('Ansible Deploy') {
           steps {
               sh 'ls -ltrh'
               sh 'ansible-playbook --vault-password-file=/var/lib/jenkins/.vault_pass -i inventory mysecondplaybook.yml'
            }
        }
          /*    stage('OWASP DAST') {
           steps {
               sh '''
                docker pull owasp/zap2docker-stable
                docker run -dt --name owasp owasp/zap2docker-stable sh
                docker exec owasp mkdir /zap/wrk
                docker exec owasp zap-baseline.py -t http://13.232.140.244:8080/hello-world-maven/ -x report.xml -I
                echo $WORKSPACE
                docker cp owasp:/zap/wrk/report.xml $WORKSPACE/report.xml
                docker stop owasp && docker rm owasp
                
               '''
            }
        }*/
 /*              stage('Selenium Testing') {
           steps {
               sh '''
                export CLASSPATH=".:/var/lib/jenkins/selenium-server-standalone.jar:/var/lib/jenkins/testng-6.8.7.jar"
                java seleniumTest.java
                
                '''
           }
        }*/
        stage('Selenium TESTS') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Publish Testng report in Jenkins dashboard') {
            steps {
                testNG reportFilenamePattern: 'target/surefire-reports/testng-results.xml'
            }
        }
    }
   /* post { 
        always { 
            cleanWs()
        }
    }*/
    post{
        always{
//            emailext to: "musthamsd@gmail.com",
//            subject: "Selenium Report",
//            body: "${"/var/lib/jenkins/workspace/Selenium-Grid-Pipeline/target/surefire-reports/emailable-report.html"}"
  //          emailext attachLog: true, attachmentsPattern: '**/target/surefire-reports/emailable-report.html', body: 'TEST Report', presendScript: '''def reportPath = build.getWorkspace().child("target/surefire-reports/emailable-report.html")
//msg.setContent(reportPath.readToString(), "text/html");''', subject: 'Automation testing result', to: 'musthamsd@gmail.com'
            emailext attachLog: true, attachmentsPattern: '**/target/surefire-reports/emailable-report.html', body: 'Please find the attachment of the selenium testing report', subject: 'Selenium Testing Report', to: 'musthamsd@gmail.com'
        }
    }
}
