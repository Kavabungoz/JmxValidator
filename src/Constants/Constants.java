package Constants;

public class Constants {

    /* Список значений атрибута testname, которые необходимо проверить перед тем, как валидировать статус атрибута enabled */
    public final static String[] ARRAY_OF_ATTRIBUTES = {"View Results Tree","Summary Report","Aggregate Report","Aggregate Graph","Response Time Graph","View Results in Table","jp@gc - Active Threads Over Time","jp@gc - Response Times Distribution","jp@gc - Response Times Over Time","jp@gc - Response Times Percentiles","jp@gc - Transactions per Second"};

    /* Стандартное имя тэга Jmeter листенера */
    public final static String TAG_RESULTCOLLECTOR = "ResultCollector";

    /* Имя тэга Jmeter листенера из плагина jp@gc */
    public final static String TAG_JPGC_RESULTCOLLECTOR = "kg.apc.jmeter.vizualizers.CorrectedResultCollector";

}
