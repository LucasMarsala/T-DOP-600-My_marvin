import jenkins.model.Jenkins

folder('Tools') {
    displayName('Tools')
    description('Folder for miscellaneous tools.')
}

freeStyleJob('Tools/clone-repository') {
    description("Git URL of the repository to clone")
    scm {
        github('https://github.com/LucasMarsala/T-DOP-600-My_marvin.git', 'main')
    }
    publishers {
    cleanWs {
        cleanWhenAborted(true)
        cleanWhenFailure(true)
        cleanWhenNotBuilt(false)
        cleanWhenSuccess(true)
        cleanWhenUnstable(true)
        deleteDirs(true)
        notFailBuild(true)
        disableDeferredWipeout(true)
        }
    }
}
