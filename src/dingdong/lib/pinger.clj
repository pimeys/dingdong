(ns dingdong.lib.pinger
  (require [clj-http.client :as client]))

(defn ping-with-sleep [url]
  (loop []
    (let [wait-time (rand-int 200)]
      (time (println (:status (client/get url
                                          {:socket-timeout 30000
                                           :conn-timeout 30000}))))
      (Thread/sleep wait-time)
      (recur))))

(defn start [url, pingers]
  (repeat pingers (future (ping-with-sleep url))))

