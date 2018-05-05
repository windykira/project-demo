package com.haoze.service.impl.system;

import com.haoze.common.model.Tree;
import com.haoze.dao.system.DepartmentDao;
import com.haoze.model.system.entity.DepartmentEntity;
import com.haoze.service.system.DepartmentService;
import com.haoze.utils.TreeBuildUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 部门数据服务实现类。
 * @author maxl 2018-05-02。
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao departmentMapper;

    @Override
    public Tree<DepartmentEntity> getTree() {

        List<Tree<DepartmentEntity>> trees = new ArrayList();
        List<DepartmentEntity> departments = departmentMapper.list(new HashMap<String,Object>(16));
        for (DepartmentEntity department : departments) {

            Tree<DepartmentEntity> tree = new Tree();
            tree.setId(department.getDeptId().toString());
            tree.setParentId(department.getParentId().toString());
            tree.setText(department.getName());
            Map<String, Object> state = new HashMap<>(16);
            state.put("opened", true);
            tree.setState(state);
            trees.add(tree);
        }
        // 默认顶级菜单为０，根据数据库实际情况调整
        Tree<DepartmentEntity> tree = TreeBuildUtil.build(trees);
        return tree;
    }
}
