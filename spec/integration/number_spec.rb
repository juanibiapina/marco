require 'helpers/integration'

describe "a number" do
  it "returns itself" do
    run "1"

    expect(result).to eq("1")
  end
end
