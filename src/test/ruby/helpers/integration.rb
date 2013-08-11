include Java

$CLASSPATH << "build/classes/main"

java_import "marco.Interpreter"

module IntegrationHelper
  def run(code)
    @result = Interpreter.new.run(code)
  end

  def result
    @result
  end
end

RSpec.configure do |c|
  c.include IntegrationHelper
end
