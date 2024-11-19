package ru.rsreu.golyashhuk.querytype;

import ru.rsreu.golyashhuk.datastructure.DoubleSideMap;

public class QueryTypeConverter {
    private static final DoubleSideMap<QueryTypeEnum, Integer> QUERY_TYPE_TO_INT = new DoubleSideMap<QueryTypeEnum, Integer>() {
        {
            put(QueryTypeEnum.GET, 1);
            put(QueryTypeEnum.REPAIR, 2);
            put(QueryTypeEnum.RETURN, 3);
        }
    };

    public static int getIdByQueryType(QueryTypeEnum queryType) {
        return QUERY_TYPE_TO_INT.getValue(queryType);
    }
}
