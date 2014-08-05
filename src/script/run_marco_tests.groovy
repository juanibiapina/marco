import marco.runner.Runner

Runner runner = new Runner()

new File('src/test').eachFileRecurse() {
    if (it.name.endsWith('.mrc')) {
        runner.run(it.absolutePath)
    }
}