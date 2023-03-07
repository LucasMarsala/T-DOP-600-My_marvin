freeStyleJob('CreateJobs') {
    displayName($DISPLAY_NAME)
    triggers {
        scm('* * * * *')
    }
    scm {
        github($GITHUB_NAME)
    }
    wrappers {
        preBuildCleanup()
    }
    steps {
      shell('make fclean')
      shell('make')
      shell('make tests_run')
      shell('make clean')
   }
}
