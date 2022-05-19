(ns smart-bash.parse)

(defn parse []
  [:div
   (for [line (-> "output.txt" slurp (.split "\n"))]
     [:div line])])
