//def git() {
def call(Stging repourl) {
//git branch: 'jenkins-selenium-grid', url: 'https://github.com/MusthafaMashkura/jenkins-cicd-ansible.git'
  git branch: 'jenkins-selenium-grid', url:"${repourl}"
}
