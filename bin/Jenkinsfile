pipeline {
  agent any
  stages {
    stage('Begin') {
      parallel {
        stage('Email') {
          steps {
            echo 'Gerando emails'
            mail(subject: '[CI/CD] Pipeline start', body: 'Pipeline sendo executada', charset: 'UTF-8', to: 'ewaldoj18@gmail.com, marianaoliveirafernandes11@gmail.com, jejosu346@gmail.com, isaniovitor@alu.ufc.br, falcaof14@alu.ufc.br')
            echo 'Emails enviados com sucesso'
          }
        }

        stage('Commitlint') {
          steps {
            echo 'Testando o commit'
          }
        }

      }
    }

    stage('Build') {
      parallel {
        stage('Build') {
          steps {
            echo 'Buildando app'
          }
        }

        stage('Docker') {
          steps {
            echo 'Testando com Docker'
          }
        }

        stage('Message') {
          steps {
            echo 'Builde e docker ok'
          }
        }

      }
    }

    stage('Tests') {
      parallel {
        stage('Unit') {
          steps {
            echo 'Unit Tests'
          }
        }

        stage('Integration') {
          steps {
            echo 'Integration Tests'
          }
        }

        stage('SonarQube') {
          steps {
            echo 'Using Sonar Qube '
          }
        }

        stage('Message') {
          steps {
            echo 'Testes finalizados'
          }
        }

      }
    }

    stage('Deploy') {
      parallel {
        stage('Deploy') {
          steps {
            echo 'Atualizando imagem docker'
          }
        }

        stage('Message') {
          steps {
            echo 'Sucesso'
          }
        }

      }
    }

    stage('Finish') {
      steps {
        echo 'Email com relatorios'
      }
    }

  }
}