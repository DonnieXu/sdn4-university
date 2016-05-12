/*
 * Copyright [2011-2016] "Neo Technology"
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
 *
 */
package school.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import school.domain.StudyBuddy;
import school.repository.StudyBuddyRepository;

@Service("studyBuddyService")
public class StudyBuddyServiceImpl extends GenericService<StudyBuddy> implements StudyBuddyService {

    @Autowired
    private StudyBuddyRepository repository;

    @Override
    public GraphRepository<StudyBuddy> getRepository() {
        return repository;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Iterable<Map<String,Object>> getStudyBuddiesByPopularity() {
        return repository.getStudyBuddiesByPopularity();
    }
}
