require 'helpers/integration'

describe "nil" do
  it "returns itself" do
    run "nil"

    expect(result).to eq("nil")
  end
end
