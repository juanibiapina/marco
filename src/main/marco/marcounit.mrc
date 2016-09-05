(def :test-case (function [:name :runnable] {
  [name runnable]
}))

(def :test-case-result (function [:name :result] {
  [name result]
}))

(def :print-results (function [:result] {
  (print (head result))
}))

(def :run-test-case (function [:test-case] {
  (test-case-result (head test-case) ((head (tail test-case))))
}))

(def :run-tests (function [:test-list] {
  (let [:failed-results { (filter (function [:test-case-result] {
                                    (not (head (tail test-case-result)))
                                  })
                                  (map run-test-case test-list))
                        }]
    {
      (map print-results failed-results)
      (if (> (length failed-results) 0)
          { (exit 1) }
          { nil })
    })
}))

(export [:test-case :run-tests])
