(def :cons @"Creates a list"
  (function [:head :tail] {
    (with-meta (pair head tail) #{:length (+ 1 ((meta tail) :length))})
  })
)

(def :head @"Returns the head of a list"
  (function [:list] {
    (first list)
  })
)

(def :tail @"Returns the tail of a list"
  (function [:list] {
    (second list)
  })
)

(def :length @"Determines the length of a list"
  (function [:list] {
    ((meta list) :length)
  })
)

(def :list? @"Checks whether something is a list"
  (function [:list] {
    (if (nil? list) { true } {
      (if (pair? list) {
        (recurse (tail list))
      } {
        false
      })
    })
  })
)

(def :foldl @"Left fold"
  (function [:pred :initial-value :list] {
    (if (nil? list)
      { initial-value }
      { (recurse pred (pred initial-value (head list)) (tail list)) }
    )
  })
)

(export [:cons :length :list? :head :tail :foldl])
