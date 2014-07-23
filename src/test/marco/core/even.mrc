(include "marcounit")

(def :even-tests [
  (test-case "0 is even" (function [] {
    (even? 0) }))

  (test-case "1 is not even" (function [] {
    (not (even? 1)) }))

  (test-case "2 is even" (function [] {
    (even? 2) }))

  (test-case "3 is not even" (function [] {
    (not (even? 3)) }))
])

(run-tests even-tests)
