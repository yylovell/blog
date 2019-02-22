package com.yy.blog.repository;

import com.yy.blog.domain.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Vote 仓库.
 *
 * @since 1.0.0 2017年4月9日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
public interface VoteRepository extends JpaRepository<Vote, Long>{
 
}
