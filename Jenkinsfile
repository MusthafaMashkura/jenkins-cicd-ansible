pipeline {
    agent any
    tools { 
        maven 'mymaven' 
        jdk 'myjdk' 
    }
     
    stages {
      stage('checkout') {
           steps {
             
                git branch: 'jenkins-selenium', url: 'https://github.com/MusthafaMashkura/jenkins-cicd-ansible.git'
             
          }
        }
      stage('Code Analysis') {
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
        }
                  /*   stage('Owasp Dependency check') {
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
           /*   stage('OWASP DAST') {
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
         stage('Selenium Testing') {
           steps {
               sh 'mvn test'
            }
        }
    }
/*    post { 
        always { 
            cleanWs()
        }
    }*/
}
