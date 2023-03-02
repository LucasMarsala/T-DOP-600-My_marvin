import jenkins.model.Jenkins

folder('Tools') {
    displayName('Tools')
    description('Folder for miscellaneous tools.')
}

freeStyleJob('Tools/clone-repository') {
    description("Git URL of the repository to clone")
    wrappers {
        preBuildCleanup { // Clean before build
            includePattern('**/*')
            deleteDirectories()
            cleanupParameter('CLEANUP')
        }

    }
    steps {
        shell('git clone https://github.com/LucasMarsala/T-DOP-600-My_marvin.git')
    }
}
