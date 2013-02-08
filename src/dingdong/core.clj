(ns dingdong.core
  (:require [dingdong.lib.pinger :as pinger]))

(defn -main [& args]
  (let [command (first args), params (rest args)]
    (cond (= command "ping")
            (let [url (first params), pingers (last params)]
              (pinger/start url (Integer/parseInt pingers)))
          :else (str "Invalid command " command))))
