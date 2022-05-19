(ns smart-bash.parse)

(defn parse []
  [:div
   (for [line (-> "output.txt" slurp (.split "\n"))]
     (if-let [file (re-find #"/Users.*\.tsx?" line)]
       (let [[a b] (.split line file)]
         [:div
          a
          [:a {:href "#"
               :hx-post "root:open"
               :hx-vals {:file file}} file]
          b])
       [:div line]))])
