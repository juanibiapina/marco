require 'helpers/integration'

describe "a string" do
  it "returns itself" do
    run %q("sample string")

    expect(result).to eq(%q("sample string"))
  end
end
