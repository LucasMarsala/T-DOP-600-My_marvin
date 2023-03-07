import jenkins.model.Jenkins

folder('Tools') {
    displayName('Tools')
    description('Folder for miscellaneous tools.')
}

freeStyleJob('Tools/clone-repository') {
    parameters {
      stringParam('GIT_REPOSITORY_URL', '', 'Git URL of the repository to clone')
    }
    wrappers {
        preBuildCleanup()
    }
    steps {
      shell('git clone $GIT_REPOSITORY_URL')
    }
}

Job('test') {
  steps {
    shell('echo "bite"')
  }
}

Job('Tools/SEED') {
    parameters {
      stringParam('GITHUB_NAME', '', 'GitHub repository owner/repo_name (e.g.: "EpitechIT31000/chocolatine")')
      stringParam('DISPLAY_NAME', '', 'Display name for the job')
    }
    steps {
      build job: 'test'
    }
}
