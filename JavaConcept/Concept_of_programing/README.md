# 程式設計重點概念
* Coupling（耦合）
    * 耦合度描述了兩個模組（類別、方法等）之間的相互依賴程度。當模組之間的耦合度高時，它們彼此之間相互關聯度強，修改其中一個模組可能會影響其他模組。反之，如果耦合度低，則模組之間相互獨立，修改一個模組不會影響其他模組。低耦合度是設計優良的原則，因為它提高了程式的可讀性、可維護性和可擴展性。
* Cohesion（內聚性）
    * 內聚性描述了一個模組（類別、方法等）內部元素之間的相關程度。高內聚性表示模組內的元素具有很強的關聯性，功能相近，共同完成一個明確的任務。低內聚性表示模組內的元素功能散落、不相關，容易導致程式碼的雜亂和不易理解。高內聚性有助於提高程式碼的可讀性和理解性。
    
* Association（關聯）
    * 關聯表示兩個物件之間的關係，例如，一個物件可能包含另一個物件作為其成員，或者兩個物件之間可能有某種操作關係。關聯是一種比較鬆散的連接方式，物件之間可能是雙向關聯或單向關聯。
* Aggregation（聚合）
    * 聚合是一種特殊的關聯型態，表示一個物件包含了其他物件，但它們之間是關聯的且具有獨立的生命週期。例如，一個大學可以包含多個學院，學院和大學是聚合關係。當大學不存在時，學院仍然可以獨立存在。
* Composition（組合）
    * 組合也是一種特殊的關聯型態，表示一個物件包含了其他物件，但它們之間具有強烈的關聯性，且共同構成一個整體。不同於聚合，組合的子物件與父物件的生命週期是相依的，即當父物件不存在時，子物件也會被銷毀。例如，一個汽車由引擎、車輪等組成，汽車和其部件之間是組合關係。