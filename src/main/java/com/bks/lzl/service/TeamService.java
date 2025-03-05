package com.bks.lzl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bks.lzl.model.domain.Team;
import com.bks.lzl.model.domain.User;
import com.bks.lzl.model.dto.TeamQuery;
import com.bks.lzl.model.request.TeamJoinRequest;
import com.bks.lzl.model.request.TeamQuitRequest;
import com.bks.lzl.model.request.TeamUpdateRequest;
import com.bks.lzl.model.vo.TeamUserVO;

import java.util.List;

public interface TeamService extends IService<Team> {

    long addTeam(Team team, User loginUser);

    List<TeamUserVO> listTeams(TeamQuery teamQuery, boolean isAdmin);

    boolean updateTeam(TeamUpdateRequest teamUpdateRequest, User loginUser);

    boolean joinTeam(TeamJoinRequest teamJoinRequest, User loginUser);

    boolean quitTeam(TeamQuitRequest teamQuitRequest, User loginUser);

    boolean deleteTeam(long id, User loginUser);
}
