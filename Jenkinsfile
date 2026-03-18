pipeline {
 agent any
 stages {
  stage('Build'){steps{
   dir('user-service'){bat 'mvn clean package -DskipTests'}
   dir('inventory-service'){bat 'mvn clean package -DskipTests'}
   dir('order-service'){bat 'mvn clean package -DskipTests'}
  }}
  stage('Docker'){steps{bat 'docker compose build'}}
 }
}
