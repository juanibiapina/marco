require 'helpers/integration'

describe "a number" do
  context "integer" do
    it "returns itself" do
      run "1"

      expect(result).to eq("1")
    end
  end

  context "real" do
    it "returns itself" do
      run "1.4"

      expect(result).to eq("1.4")
    end
  end
end
