package pers.cxt.bms.database.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;
import pers.cxt.bms.database.entity.BmClassify;
import pers.cxt.bms.database.entity.BmClassifyCriteria.Criteria;
import pers.cxt.bms.database.entity.BmClassifyCriteria.Criterion;
import pers.cxt.bms.database.entity.BmClassifyCriteria;

public class BmClassifySqlProvider {

    public String countByExample(BmClassifyCriteria example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("bm_classify");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(BmClassifyCriteria example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("bm_classify");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(BmClassify record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("bm_classify");
        
        if (record.getClassifyId() != null) {
            sql.VALUES("classify_id", "#{classifyId,jdbcType=VARCHAR}");
        }
        
        if (record.getClassify() != null) {
            sql.VALUES("classify", "#{classify,jdbcType=VARCHAR}");
        }
        
        if (record.getSubClassify() != null) {
            sql.VALUES("sub_classify", "#{subClassify,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String selectByExample(BmClassifyCriteria example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("classify_id");
        } else {
            sql.SELECT("classify_id");
        }
        sql.SELECT("classify");
        sql.SELECT("sub_classify");
        sql.SELECT("create_time");
        sql.SELECT("update_time");
        sql.FROM("bm_classify");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        BmClassify record = (BmClassify) parameter.get("record");
        BmClassifyCriteria example = (BmClassifyCriteria) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("bm_classify");
        
        if (record.getClassifyId() != null) {
            sql.SET("classify_id = #{record.classifyId,jdbcType=VARCHAR}");
        }
        
        if (record.getClassify() != null) {
            sql.SET("classify = #{record.classify,jdbcType=VARCHAR}");
        }
        
        if (record.getSubClassify() != null) {
            sql.SET("sub_classify = #{record.subClassify,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("bm_classify");
        
        sql.SET("classify_id = #{record.classifyId,jdbcType=VARCHAR}");
        sql.SET("classify = #{record.classify,jdbcType=VARCHAR}");
        sql.SET("sub_classify = #{record.subClassify,jdbcType=VARCHAR}");
        sql.SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        sql.SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        
        BmClassifyCriteria example = (BmClassifyCriteria) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(BmClassify record) {
        SQL sql = new SQL();
        sql.UPDATE("bm_classify");
        
        if (record.getClassify() != null) {
            sql.SET("classify = #{classify,jdbcType=VARCHAR}");
        }
        
        if (record.getSubClassify() != null) {
            sql.SET("sub_classify = #{subClassify,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("classify_id = #{classifyId,jdbcType=VARCHAR}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, BmClassifyCriteria example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}