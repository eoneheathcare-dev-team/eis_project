pipeline {
      agent any

      stages {
          stage('Build Image') {
              steps {
                  sh 'DOCKER_BUILDKIT=1 docker build -t eis:latest .'
              }
          }

          stage('Deploy') {
              steps {
                  sh '''
                      docker rm -f eis || true
                      docker run -d \
                        --name eis \
                        --restart unless-stopped \
                        --network proxy-network \
                        -p 127.0.0.1:8080:8080 \
                        eis:latest
                  '''
              }
          }
      }
  }