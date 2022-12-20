plugins {
    id("org.danilopianini.gradle-pre-commit-git-hooks") version "1.1.0"
}
rootProject.name = "devops.practice"

gitHooks {
    commitMsg {
        conventionalCommits()
    }
    createHooks(true)
}