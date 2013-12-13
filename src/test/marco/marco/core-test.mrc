(include "marco.unit")

(def filter-tests
  (test-group "filter" (
    (test-case "matches all elements"
      (check-equal? (filter (function (x) true) '(1 2 3)) '(1 2 3)))

    (test-case "matches tail elements"
      (check-equal? (filter (function (e) (> e 3)) '(3 4 5)) '(4 5)))
  ))
)

(run-tests filter-tests)