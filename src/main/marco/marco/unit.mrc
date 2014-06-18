(def :test-group (data [:name :tests]))
(def :test-case (data [:name :runnable]))

(def :test-case-result (data [:name :result]))

(def :print-results (function [:result] {
                      (print result.name) }))

(def :run-test-case (function [:test-case] {
    (test-case-result test-case.name (test-case.runnable)) }))

(def :run-tests (function [:group] {
  (let [:failed-results { (filter (function [:test-case-result] {
                                    (not test-case-result.result)
                                  })
                                  (map run-test-case group.tests))
                        }]
    {
      (map print-results failed-results)
      (if (> (length failed-results) 0)
          { (exit 1) }
          {nil})
    })
}))
