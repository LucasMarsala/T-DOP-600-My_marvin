import jenkins.model.Jenkins

folder('Tools') {
    displayName('Tools')
    description('Folder for miscellaneous tools.')
}

freeStyleJob('Tools/clone-repository') {
    description("Git URL of the repository to clone")
    environmentVariables {
      envs(URL: 'https://github.com/LucasMarsala/T-DOP-600-My_marvin.git', description: 'Git URL of the repository to clone')
    }
    wrappers {
        preBuildCleanup {
        }
    }
    steps {
      shell('git clone $URL')
    }
}

freeStyleJob('Tools/SEED') {
    wrappers {
        preBuildCleanup { // Clean before build
        }
    }
    steps {
          shell('make fclean')
          shell('make')
          shell('make tests run')
          shell('make clean')
    }
}
